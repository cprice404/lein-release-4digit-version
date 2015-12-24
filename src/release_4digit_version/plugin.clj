(ns release-4digit-version.plugin
  (:require [robert.hooke :as hooke]
            [leiningen.release]
            [leiningen.release-4digit-version :as release-4d]))

(defn add-bump-4d-version
  [f & args]
  (apply release-4d/bump-version args))

(defn hooks
  [& args]
  (println "ADDING 4dv hooks!" args)
  (hooke/add-hook #'leiningen.release/bump-version
                  #'release-4digit-version.plugin/add-bump-4d-version))
