(ns clojewel.common)

(defn shared-fn
  "A function that is shared between clj and cljs"
  []
  (println "cljc!"))


;;;;
;(require '[cljs.repl :as repl])
;(require '[cljs.repl.rhino :as rhino])

;(def env (rhino/repl-env)) ;; create a new environment
;(repl/repl env) ;; start the REPL
;;;;


