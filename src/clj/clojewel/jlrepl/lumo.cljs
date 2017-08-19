(ns cljs.user
  (:require [cljs.analyzer :as ana]
            [cljs.analyzer.api :as ana-api]
            [cljs.compiler :as comp]
           ; [cljs.compiler.api :as comp-api]
            [cljs.env :as env]
           ; [cljs.util :as util]
            [clojure.walk :as w]
            [cljs.tagged-literals :as tags]))




(js/console.log "Hello, Lumo!")

(def test-cenv (atom {}))
(def test-env (assoc-in (ana/empty-env) [:ns :name] 'cljs.user)

(comp/emit
 (ana/analyze aenv
              '(let [{:keys [a] :or {b 2}} {:a 1}] [a b])))

(ana/analyze test-env
             '(ns cljs.user
                (:use [clojure.string :only [join]])))


(comp/emit
 (ana/analyze (assoc aenv :context :expr) 'js/-Infinity))





  (defrecord Rec1 [a])

  (defn inc-leaf [x]
    (if (number? x)
      (inc x)
      x))

  (w/prewalk #(if (keyword? %) (str %) %) (Rec1. 1))


;(for [i (range 10)]
; (println i))



;;;;;;;;;;;;;
  ;; 10 August 2017
(ns cljs.user
  (:require
   [clojure.pprint :as pp]
   [cljs.tools.reader :as reader]
   [cljs.tools.reader.reader-types :as readers]
   [cljs.analyzer :as ana]
   [cljs.compiler :as c]
;   [cljs.closure :as cc]
   [cljs.env :as env]))


  (defn emit-str [ast]
    (with-out-str (c/emit ast)))
