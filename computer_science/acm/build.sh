pandoc $1.md --verbose --template=default.latex -t beamer --slide-level 1 --pdf-engine=xelatex -f markdown+fenced_code_attributes -f markdown+multiline_tables -o $1.pdf
