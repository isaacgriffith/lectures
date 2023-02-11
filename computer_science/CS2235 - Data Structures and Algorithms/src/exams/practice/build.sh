#!/bin/bash

set -e

./build_latex.sh $1
tempdir=$(mktemp -d)

latexmk -xelatex -pdf $1 -outdir=$tempdir
cp $tempdir/$1.pdf $1.pdf

latexmk -xelatex -pdf $1_solutions -outdir=$tempdir
cp $tempdir/$1_solutions.pdf $1_solutions.pdf

# cleanup
rm -rf $tempdir
rm $1.gen.md
rm $1.tex
rm $1_solutions.tex
