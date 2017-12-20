(ns {{ns-name}}.handler
  (:require [compojure.route :as route]
            [ring.util.response :as resp]
            [compojure.core :refer [routes ANY]]))


(defn app-routes [component]
  (routes
    (ANY "*" []
          "Hello world!")))



