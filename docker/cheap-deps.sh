#!/bin/bash

original_classpath=$(lein classpath)

new_classpath=""
IFS=":"
for path in $original_classpath; do
    if [[ $path == *.jar ]]; then
        jar_basename=$(basename "$path" .jar)
        target_dir="/app/dependencies/$jar_basename"
        mkdir -p "$target_dir"
        unzip -q -o "$path" -d "$target_dir"
        new_classpath="$new_classpath:$target_dir"
    else
        new_classpath="$new_classpath:$path"
    fi
done

echo "${new_classpath#:}"
