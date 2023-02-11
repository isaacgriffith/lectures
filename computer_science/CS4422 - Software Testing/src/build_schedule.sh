#!/bin/sh

set -e

pp schedule.md > schedule.gen.md
pandoc schedule.gen.md --template=../../common/templates/schedule_template.latex --top-level-division=section --pdf-engine=xelatex -o ../production/schedule.pdf
rm schedule.gen.md
