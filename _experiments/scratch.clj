(ns user
  (:require [clojure.string :refer [join trim]]))

(defn lazy? [x]
  (instance? clojure.lang.LazySeq x))

(defn attr-value->html [value]
  (let [q "\""]
    (cond
      (keyword? value) (str q (name value) q)
      (number? value) value
      :else (str q value q))))

(defn attr->html [[key value]]
  (let [key (name key)]
    (cond
      (or (false? value)
          (nil? value)) nil
      (true? value) key
      :else (str key "=" (attr-value->html value)))))

(defn attrs->html [attrs]
  (->> (map attr->html attrs)
       (remove nil?)
       (join " ")))

(declare node->html nodes->html nodes->html-without-offset)

(defn tag->html [[tag attrs children]]
  (let [tag (name tag)
        attrs (attrs->html attrs)
        attrs-offset (when-not (empty? attrs) " ")]
    (concat [(str "<" tag attrs-offset attrs ">")]
            (nodes->html children)
            [(str "</" tag ">")])))

(defn node->tag [[tag attrs & children]]
  (let [attrs? (map? attrs)]
    (if attrs?
      [tag attrs children]
      [tag {} (cons attrs children)])))

(defn node->html [node]
  (cond
    (lazy? node) (nodes->html-without-offset node)
    (vector? node) (tag->html (node->tag node))
    (keyword? node) [(name node)]
    :else [(str node)]))

(defn nodes->html-without-offset [nodes]
  (->> (map node->html nodes)
       (remove empty?)
       (reduce concat)))

(defn nodes->html [nodes]
  (->> (nodes->html-without-offset nodes)
       (map #(str "  " %))))

(defn ->html [ast]
  (-> (node->html ast)
      (->> (remove (comp empty? trim))
           (join "\n"))))


;;;;;; SHOW TIME


(let [data [{:name "Kana",   :age 18, :active? true}
            {:name "Andrew", :age 18}]
      ast [:div {:class "container"}
           (when false
             [:div "This block will never be visible"])
           [:table
            [:thead
             [:tr
              [:th "Name"]
              [:th "Age"]]]
            [:tbody
             (for [{:keys [name age active?]} data]
               [:tr {:class (when active? "active")}
                [:td name]
                [:td age]])]]]]


;  (->html ast))
  (println (->html ast)))





