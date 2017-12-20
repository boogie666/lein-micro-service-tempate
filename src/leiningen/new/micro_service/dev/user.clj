(ns user
  (:require
   [com.stuartsierra.component :as component]
   [{{ns-name}}.systems :as root]))


(def application nil)

(defn start []
  (alter-var-root #'application (fn [_] (component/start (root/system)))))


(defn stop []
  (alter-var-root #'application (fn [x] (when x (component/stop x)))))


(defn go []
  (stop)
  (start))
