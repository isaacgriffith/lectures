#!/bin/bash

set -e

./build_latex.sh $1
tempdir=$(mktemp -d)

latexmk -pdf $1 -outdir=$tempdir # would add -c but a bug makes it not work in version 4.41. Fixed in later version of latexmk.
cp $tempdir/$1.pdf $1.pdf

latexmk -pdf $1_solutions -outdir=$tempdir # would add -c but a bug makes it not work in version 4.41. Fixed in later version of latexmk.
cp $tempdir/$1_solutions.pdf $1_solutions.pdf

# cleanup
rm -rf $tempdir
rm $1.gen.md
rm $1.tex
rm $1_solutions.tex
