(ns cljs.tools.test-runner
  (:require cljs.tools.reader-test
            [cljs.test :refer-macros [run-all-tests]]))

(enable-console-print!)
(run-all-tests)
