#!/bin/sh
FILE=test
if [ -d "$FILE" ]; then
    echo "$FILE is a directory"
fi
