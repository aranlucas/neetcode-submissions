"""Compile judge snippets in isolation and run their colocated behavior fixtures."""

from pathlib import Path
import subprocess
import tempfile


ROOT = Path(__file__).resolve().parents[1]


def main():
    submissions = sorted((ROOT / "Data Structures & Algorithms").glob("*/submission-*.java"))
    if not submissions:
        raise SystemExit("No submissions found")

    for submission in submissions:
        fixture = submission.with_name("BehaviorTest.java")
        if not fixture.is_file():
            raise SystemExit(f"Missing behavior fixture: {fixture.relative_to(ROOT)}")
        print(f"Checking {submission.relative_to(ROOT)}", flush=True)
        with tempfile.TemporaryDirectory(prefix="neetcode-") as directory:
            work = Path(directory)
            (work / "Solution.java").write_text(
                "import java.util.*;\n" + submission.read_text(encoding="utf-8"),
                encoding="utf-8",
            )
            subprocess.run(
                ["javac", "-d", directory, str(work / "Solution.java"), str(fixture)],
                check=True,
                timeout=30,
            )
            subprocess.run(
                ["java", "-cp", directory, "BehaviorTest"], check=True, timeout=30
            )


if __name__ == "__main__":
    main()
