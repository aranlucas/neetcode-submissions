# Untangle decision log

## Inventory before edits — 2026-11-06

Baseline: `446fa32`. Working tree was clean. Read root `AGENTS.md`, README,
ROADMAP, all eight Java submissions, both workflows, Dependabot configuration,
and the icon. No nested instructions, existing tests, local test sessions owned
by this thread, or prior refactor findings were present.

Applied the fetched caldoai `untangle-codebase` skill with Comments and Tests
selected. All test execution is CI-only per user instruction.

## Design and problems

- Keep each synced attempt intact; adapt the execution boundary to judge snippets.
  - Hidden convention: all eight files define `Solution` and rely on judge-provided
    `java.util` imports. A normal whole-tree compilation cannot validate them.
  - CI currently checks only patch whitespace; no behavior is protected.
  - Put a Java behavior fixture beside each problem and use one runner to supply
    imports and compile/run each attempt in a fresh temporary directory. Discover
    attempts rather than maintaining another filename list. Fail on missing
    fixtures so incoming problem additions cannot silently bypass validation.
- Preserve archive provenance and problem boundaries.
  - Two is-anagram attempts intentionally repeat logic. They are historical
    submissions, not shared runtime modules; extracting helpers would destroy
    the judge-compatible contract and violate ROADMAP's preservation decision.
  - Empty-input handling and unequal-length handling are algorithm requirements,
    not cross-module coupling. Keep them. No retries, sleeps, swallowed exceptions,
    disabled tests, pass-through wrappers, or unused extension points exist.
- Colocate independently justified examples with their problem.
  - Test duplicate detection, anagram multiplicity, group membership independent
    of map iteration order, consecutive runs with duplicates, container width,
    minimum feasible eating speed, and exact top-k membership without ordering
    assumptions. Both archived anagram attempts must satisfy the same contract.
  - Judge inputs remain the contract; do not invent behavior outside the exercise
    constraints (such as integer extremes for bounded-value problems).
- Comments and existing tests: no redundant source comments or tests to remove.
  Keep workflow security and permission explanations: they describe external
  GitHub constraints rather than restating implementation.

## Validation plan

Run the isolated behavioral fixtures on Java 17 in the existing CI job. Static
review only locally; no local tests, benchmark, browser tests, or test builds.
Review the complete repository with one subagent at a time, resolve worthwhile
findings, and repeat until clean. Record CI and review outcomes below.

## Fixture rationale (before CI execution)

| Contract | Credible regression | Independent expected result |
| --- | --- | --- |
| Duplicate detection | Only adjacent duplicates detected, or all values flagged | `[1,2,1]` repeats 1; `[1,2,3]` contains no repeat |
| Anagrams | Compare only distinct letters or skip length mismatch | `aab` and `abb` have different multiplicities; `anagram` and `nagaram` have the same letters |
| Groups | Lose repeated input or merge unrelated signatures | The seven words partition into groups of four, two, and one, retaining both `eat` occurrences |
| Consecutive run | Count duplicates as steps, skip negative values, or return 1 on empty input | The run 1–4 has length 4; -2–0 has length 3; empty input has length 0 |
| Container area | Use taller wall, lose width, or advance the wrong endpoint | Walls at indices 1 and 8 bound area 7×7=49; endpoint walls `[5,1,1,5]` bound 5×3=15 |
| Eating speed | Truncate per-pile time, return feasible but nonminimal speed, or overflow hours | At rate 4, `[3,6,7,11]` needs 1+2+2+3=8 hours; rate 3 needs 10. Three billion-size piles need 750M hours at 4, but 1,000,000,002 at 3 |
| Top k | Keep least frequent values, duplicate results, or require arbitrary tie order | Counts for 1,2,3 are 3,2,1; requesting two yields exactly 1 and 2 |

No executable checks were run locally; `git diff --check` is a static whitespace
inspection only. CI is the behavioral validation authority.

## Static review round 1

Independent whole-repository review found no additional worthwhile structural or
behavioral changes. Resolved two small findings: README now specifically names
submission files when describing `Solution` classes; setup-java is SHA-pinned
consistently with checkout. Reviewer confirmed fixtures use independent outcomes
and honor permitted ordering. No local tests or builds were run.
