#!/bin/bash

pdflatex -halt-on-error -draftmode wibook.tex > compile.log
bibtex wibook.aux
#pdflatex wibook.tex
makeindex wibook.nlo -s nomencl.ist -o wibook.nls
pdflatex -halt-on-error -draftmode wibook.tex >> compile.log
pdflatex -halt-on-error wibook.tex >> compile.log


rm *.aux *.lot *.lof *.toc *.idx *.out *.bbl *.blg *.ilg *.ind *.log *.nlo *.nls
