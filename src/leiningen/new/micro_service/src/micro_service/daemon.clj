(ns {{ns-name}}.daemon
  (:require [com.stuartsierra.component :as component]
            [{{ns-name}}.systems :as app])
  (:import [org.apache.commons.daemon Daemon DaemonContext])
  (:gen-class
   :implements [org.apache.commons.daemon.Daemon]))

(def app-system nil)

;; Commons Daemon implementatation
(defn -init [this ^DaemonContext context]
  (alter-var-root #'app-system (constantly (app/system))))

(defn -start [this]
  (alter-var-root #'app-system component/start))

(defn -stop [this]
  (alter-var-root #'app-system component/stop))

(defn -destroy [this]
  (alter-var-root #'app-system (constantly nil)))
