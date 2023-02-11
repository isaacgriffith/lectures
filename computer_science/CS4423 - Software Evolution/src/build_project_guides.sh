#!/bin/sh

cd project
rm ../../production/project/*.pdf
markdown-pp ProjectGuidelines.mdpp -o ProjectGuidelines.md
markdown-pp ProjectGuidelines_Honors.mdpp -o ProjectGuidelines_Honors.md
markdown-pp ProjectGuidelines_Graduate.mdpp -o ProjectGuidelines_Graduate.md
pandoc ProjectGuidelines.md --template=../templates/project_guideline.latex --top-level-division=chapter --pdf-engine=xelatex --listings -o ../../production/project/ProjectGuidelines.pdf
pandoc ProjectGuidelines_Honors.md --template=../templates/project_guideline.latex --top-level-division=chapter --pdf-engine=xelatex --listings -o ../../production/project/ProjectGuidelines_Honors.pdf
pandoc ProjectGuidelines_Graduate.md --template=../templates/project_guideline.latex --top-level-division=chapter --pdf-engine=xelatex --listings -o ../../production/project/ProjectGuidelines_Graduate.pdf

for i in d*.md; do
  [ -f "$i" ] || break
  pandoc $i --metadata-file=deliverable.yaml --template=../templates/assignment_template.latex --top-level-division=chapter --pdf-engine=xelatex --listings -o ../../production/project/${i%%.*}.pdf
done
