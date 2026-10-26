# Feature roadmap

Planning baseline: `8612730b5404` on `origin/main`, 2026-10-26. This repository is a solution archive populated by NeetCode's existing GitHub Sync, not a second practice platform.

## Outcome

Find a previous attempt and remember what was learned without disrupting automatic submissions. The [README](README.md) describes the current archive and sync workflow. Preserve original submitted code and its provenance.

## 1. A small review index

Add a human-maintained index for a deliberately selected set of problems worth revisiting. Link the actual saved attempt and record the pattern, one mistake or insight, and a suggested follow-up.

Acceptance:

- Every indexed attempt exists and can be opened from the repository.
- Notes distinguish the original submission from later explanations or corrections.
- Incoming sync commits remain authoritative for their submission files; editorial notes live separately.
- The index does not imply all attempts passed unless that outcome is recorded by the source.

Pilot ten useful entries. Keep the index only if it reduces time finding an example during practice.

## 2. Compare two attempts

For recurring problems, add short explanations of the change between selected attempts: algorithm, edge case, complexity tradeoff or readability. Use Git's existing diffs and links; do not build another code browser.

Acceptance: the explanation identifies both exact attempts, and a claimed improvement is backed by an example or existing runnable check when available.

## 3. Connect the archive to study

Offer explicit links from selected notes to the separate LeetCode study repository. Share problem identity and learning notes only after deciding what may be published. A link does not authorize copying private solutions into a deployed application.

## Boundaries and evidence

Do not replace the external sync service with a custom polling script. Do not add a dashboard, account system, broad execution service or another scheduling engine. Algorithm exercises should remain algorithm exercises. Success is finding and explaining a useful earlier attempt; commit counts, accepted-submission counts and a larger archive are not evidence of improved interview performance.
