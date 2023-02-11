#!/bin/bash

set -e

pp $1.md > $1.gen.md
pandoc $1.gen.md --verbose --template=templates/main.latex --top-level-division=chapter --pdf-engine=xelatex --listings -F pandoc-crossref --citeproc -o $1.pdf
rm $1.gen.md
