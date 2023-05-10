#!/bin/bash

CLOJURE_LOAD_PATH=$(/app/docker/cheap-deps.sh)
echo export CLOJURE_LOAD_PATH=$(/app/docker/cheap-deps.sh) > /app/dependencies/load-path.sh

exec "$@"
