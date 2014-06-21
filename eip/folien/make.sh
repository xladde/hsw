#!/bin/bash

pdflatex -halt-on-error -draftmode eip2014.tex 
#bibtex eip2014.aux
pdflatex -halt-on-error eip2014.tex > log.txt
makeindex eip2014.toc eip2014.lof eip2014.lot
pdflatex -halt-on-error eip2014.tex >> log.txt

rm *.aux *.lot *.lof *.toc *.idx *.out *.bbl *.blg *.ilg *.ind *.log