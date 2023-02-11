#!/bin/sh

rm ../production/schedule.pdf
pandoc schedule.md --template=templates/schedule_template.latex --top-level-division=section --pdf-engine=xelatex -o ../production/schedule.pdf
