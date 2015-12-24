(ns leiningen.release-4digit-version-test
  (:require [clojure.test :refer :all]
            [leiningen.release-4digit-version :as release-4d]))

(deftest test-bump-version
  (is (= "1.1.0" (release-4d/bump-version "1.1.0-SNAPSHOT" :release)))
  (is (= "1.1.0" (release-4d/bump-version "1.1.0" :release)))
  (is (= "1.1.1-SNAPSHOT" (release-4d/bump-version "1.1.0-SNAPSHOT")))
  (is (= "1.1.1-SNAPSHOT" (release-4d/bump-version "1.1.0")))
  (is (= "1.1.1-SNAPSHOT" (release-4d/bump-version "1.1.0-SNAPSHOT" :patch)))
  (is (= "1.1.1-SNAPSHOT" (release-4d/bump-version "1.1.0" :patch)))
  (is (= "1.3.0-SNAPSHOT" (release-4d/bump-version "1.2.0-SNAPSHOT" :minor)))
  (is (= "1.3.0-SNAPSHOT" (release-4d/bump-version "1.2.0" :minor)))
  (is (= "2.0.0-SNAPSHOT" (release-4d/bump-version "1.2.0-SNAPSHOT" :major)))
  (is (= "2.0.0-SNAPSHOT" (release-4d/bump-version "1.2.0" :major)))

  (is (= "1.1.0.0" (release-4d/bump-version "1.1.0.0-SNAPSHOT" :release)))
  (is (= "1.1.0.0" (release-4d/bump-version "1.1.0.0" :release)))
  (is (= "1.1.0.1-SNAPSHOT" (release-4d/bump-version "1.1.0.0-SNAPSHOT")))
  (is (= "1.1.0.1-SNAPSHOT" (release-4d/bump-version "1.1.0.0")))
  (is (= "1.1.0.1-SNAPSHOT" (release-4d/bump-version "1.1.0.0-SNAPSHOT" :build)))
  (is (= "1.1.0.1-SNAPSHOT" (release-4d/bump-version "1.1.0.0" :build)))
  (is (= "1.1.2.0-SNAPSHOT" (release-4d/bump-version "1.1.1.1-SNAPSHOT" :patch)))
  (is (= "1.1.2.0-SNAPSHOT" (release-4d/bump-version "1.1.1.1" :patch)))
  (is (= "1.3.0.0-SNAPSHOT" (release-4d/bump-version "1.2.3.4-SNAPSHOT" :minor)))
  (is (= "1.3.0.0-SNAPSHOT" (release-4d/bump-version "1.2.3.4" :minor)))
  (is (= "2.0.0.0-SNAPSHOT" (release-4d/bump-version "1.6.3.4-SNAPSHOT" :major)))
  (is (= "2.0.0.0-SNAPSHOT" (release-4d/bump-version "1.6.3.4" :major))))
