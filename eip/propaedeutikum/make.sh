#! /bin/bash

if [ $1 ]
    then
        pdflatex --halt-on-error --draftmode "$1.tex"
        makeindex "$1.idx"
#        makeindex "$1.nlo" -s "$1.ist" -o "$1.nls" "$1.idx" | tee -a compile.log
        makeglossaries $1
        bibtex "$1.aux"
        pdflatex --halt-on-error --draftmode "$1.tex"
        makeindex "$1.idx"
#        makeindex "$1.nlo" -s "$1.ist" -o "$1.nls" | tee -a compile.log
        makeglossaries $1
        bibtex "$1.aux"
        pdflatex --halt-on-error --file-line-error "$1.tex" | tee -a compile.log
        rm -v *.aux
        rm -v *.idx
        rm -v *.nav
        rm -v *.out
        rm -v *.toc
        rm -v *.snm
        rm -v *.bbl
        rm -v *.blg
        rm -v *.ilg
        rm -v *.ind
        rm -v *.lof
        rm -v *.lot
        rm -v *.nlo
        rm -v *.acn
        rm -v *.glo
        rm -v *.glsdefs
        rm -v *.ist
        rm -v *.acr
        rm -v *.alg
        rm -v *.glg
        rm -v *.gls
        rm -v *.nls
        mv -v *.log ./log/
        #mv *.log ./log/"$(date + %F).log"
    else
        echo "Specify an (TeX-)input file without its fileextension (.tex)"
fi
