#!/bin/bash

pdflatex wibook.tex
bibtex wibook.aux
#pdflatex wibook.tex
makeindex wibook.toc wibook.lof wibook.lot
pdflatex wibook.tex

rm *.aux *.lot *.lof *.toc *.idx *.out *.bbl *.blg *.ilg *.ind *.log
