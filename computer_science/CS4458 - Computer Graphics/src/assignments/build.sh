#!/bin/sh

set -e

pandoc $1 --template=../../../common/templates/assignment_template.latex --top-level-division=section --verbose --pdf-engine=xelatex --listings -o ../../production/assignments/$1.pdf
