#!/bin/bash

pdflatex --halt-on-error lsg.tex >> test.log
makeindex lsg.nlo -s nomencl.ist -o lsg.nls
pdflatex --halt-on-error lsg.tex  >> test.log

rm *.aux *.log *.idx *.nlo *.toc *.out *.nls *.ilg
