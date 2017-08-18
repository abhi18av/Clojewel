(ns clojewel.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [clojewel.core-test]
   [clojewel.common-test]))

(enable-console-print!)

(doo-tests 'clojewel.core-test
           'clojewel.common-test)
