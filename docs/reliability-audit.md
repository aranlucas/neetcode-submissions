# Correctness and reliability audit — 2026-11-06

## Inventory before edits

Baseline: fetched remote `main`, `54a33baf59b89369ad7ad7fda44f55083c12db51`.
The bound isolated worktree was clean. Read AGENTS.md, README, ROADMAP, the
untangle decision log, all eight saved Java attempts, seven BehaviorTest fixtures,
Python runner, both workflows and Dependabot configuration. No structural cleanup
or submission edits are proposed.

Public interfaces are the seven judge methods on independent `Solution` classes.
Inputs and outputs are in-memory exercise values. This is an archive, not a
service: no authentication, tenants, persistence, network requests, credentials,
transactions, retries or production deployment exist. Nulls, invalid k, impossible
hour budgets and integer values beyond the problem constraints are not new API
requirements. ROADMAP explicitly preserves synced attempts and their provenance.

Execution boundary: CI supplies java.util imports, compiles each attempt with its
colocated fixture in a temporary directory, then invokes BehaviorTest. Compilation
and execution failures propagate through check=True; both have 30-second bounds;
temporary directories are cleaned up on exceptions. A missing fixture or empty
archive fails explicitly. CI has a five-minute job timeout and read-only token.
The Dependabot workflow does not execute PR code, checks actor/repository/head,
and uses match-head-commit when merging to reject a changed head.

## Findings and rejected hypotheses

No concrete correctness or reliability defect established by static inspection.

| Surface | Success/failure paths and evidence |
| --- | --- |
| Duplicate integer | HashSet.add detects separated duplicates and returns false for distinct values; existing fixtures cover both and negative duplicates. |
| Both anagram attempts | Sorting preserves multiplicity and Arrays.equals rejects unequal arrays; the explicit length guard in attempt 4 is an optimization. Fixtures check multiplicity and unequal lengths on both attempts. |
| Anagram groups | Sorted string keys partition letters without losing repeated words; fixture compares unordered groups while preserving member multiplicity, including empty-string input. |
| Consecutive sequence | Deduplication and starting only at values without predecessors give each run its true length. Empty, duplicate, negative and unordered cases covered. Integer wraparound is outside this problem's bounded values; not a justified archive rewrite. |
| Water container | Limiting wall times width and advancing the shorter wall preserve the optimum; bounded heights/length keep the result within int. Existing examples catch width and endpoint mistakes. |
| Eating bananas | Feasibility is monotonic, per-pile ceiling is correct and totalTime is long. The bounded 1e9 pile maximum keeps left+right below int overflow; fixture already covers total hours above int range. Empty piles and impossible budgets are outside the exercise contract. |
| Top k | Min-heap discards the least frequent entries; result length is k and ordering is unconstrained. Count subtraction cannot overflow for bounded positive counts. Existing fixtures check exact membership, negative values, k=1 and all unique values requested. Invalid k is outside the contract. |
| Runner and CI | Each attempt gets a fresh compiler output directory, preventing duplicate Solution classes or stale class reuse. Nonzero exits and timeouts fail CI. No exception swallowing or claimed-success fallback. A synced new problem requires its own fixture. |

The existing tests establish specific example contracts, not an exhaustive proof
of algorithm correctness or acceptance by the external judge. No new regression
is justified without an identified defect; no tests were removed or weakened.

## Framework applicability and validation

There are no JavaScript/TypeScript sources, package manifests or web/native app
subprojects in the tracked inventory. tester-army/e2e and its web/mobile engines
therefore do not apply; adding a UI or npm dependency would not test an existing
user journey. The meaningful end-to-end boundary here is the existing Java
judge-snippet compile/invoke harness, executed in CI only.

No local tests, builds, benchmarks or browser checks were run. Static inspection
is the audit evidence; CI and independent review outcomes are recorded below.

Baseline CI evidence: [run 42259368640](https://github.com/aranlucas/neetcode-submissions/actions/runs/42259368640)
succeeded at the exact baseline SHA. Read its logs: all eight attempts reached
the compile/invoke harness with Java 17, which exited successfully. Deprecation
warnings for setup-java v4 do not establish a behavior defect; unrelated action
upgrades are outside this audit.

Independent review: a separate same-provider reviewer inspected the complete
repository and challenged the findings, fixtures and no-defect conclusion. No
concrete worthwhile findings or implementation objections remained. The review
confirmed a documentation-only change is appropriate; it ran no local tests or
builds. All archived submissions, fixtures and workflows remain unchanged.
