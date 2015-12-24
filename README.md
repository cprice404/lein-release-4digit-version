# release-4digit-version

A Leiningen plugin that can be used with the `release` and `change` tasks, but
supports 4-digit version numbers (e.g. 1.2.3.4, 1.2.3.4-SNAPSHOT).

Provides an alternate

The upstream `change` task supports levels `:major`, `:minor`, `:patch`, and
`:release`.  This plugin adds a level `:build`, which maps to the 4th digit in
the version string, and is the default if you do not specify a level.

## Usage

Put `[release-4digit-version "0.1.0-SNAPSHOT"]` into the `:plugins` vector of
your project.clj.

After adding the plugin dependency, you may use the