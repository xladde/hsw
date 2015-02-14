#!/bin/bash

pdflatex -halt-on-error -draftmode eip2014.tex  > log.txt
#bibtex eip2014.aux
makeindex eip2014.toc eip2014.lof eip2014.lot
#bibtex eip2014.aux
#pdflatex -halt-on-error -draftmode eip2014.tex >> log.txt
pdflatex --file-line-error -halt-on-error eip2014.tex

#rm *.aux *.lot *.lof *.toc *.idx *.out *.bbl *.blg *.ilg *.ind *.log *.nav *.snm *.txt
