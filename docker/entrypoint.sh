#!/bin/bash

mkdir -p /app/dependencies
CLOJURE_LOAD_PATH=$(bb /app/docker/cheap-deps.clj)
echo "export CLOJURE_LOAD_PATH=${CLOJURE_LOAD_PATH}" > /app/dependencies/load-path.sh
echo "Exported CLOJURE_LOAD_PATH: ${CLOJURE_LOAD_PATH}" >&2

exec "$@"
