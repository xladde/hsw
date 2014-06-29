%
% HSW SCRARTCL
%
% Custom TeX class for scientific documents at the 
% University of applied Sciences: Technology, Business and Design Wismar
%
% Author:    tj
% Version:   2014-06-29
%
\LoadClass[papersize=a4paper, fontsize=12pt]{scrartcl}
\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{hswarticle}[2013/08/20 Custom class for KOMA-Articles]

%
% Required and additional packages
%
\RequirePackage{fixltx2e}            % fix latex
\RequirePackage[utf8]{inputenc}      % inputencryption
\RequirePackage[T1]{fontenc}         % fontencryption
\RequirePackage[ngerman]{babel}      % language package
\RequirePackage[numbers]{natbib}     % bibliography
\RequirePackage{amsmath}             % math symbols etc
\RequirePackage{amssymb}             % math symbols
\RequirePackage{geometry}            % page margins
\RequirePackage{makeidx}             % index generation
\RequirePackage[intoc]{nomencl}      % nomenclature settings
\RequirePackage{setspace}            % Linespacing
\RequirePackage{float}               % floating objects
\RequirePackage{caption}             % caption inside multifloat
\RequirePackage{graphicx}            % image support (float)
\RequirePackage{listings}            % display sourcecode
\RequirePackage{multicol}            % paragraph columns
\RequirePackage{lipsum}              % generate lipsum
\RequirePackage{cclicenses}          % CC-Icons
\RequirePackage{xcolor}              % use colors
\RequirePackage{algorithm}           % Algorithm enviroment
\RequirePackage{algpseudocode}       % Enviroment for Pseudo Code
\RequirePackage{lmodern}             % something about font etc...
\RequirePackage{libertine}           % use Libertine fontset
\RequirePackage{eurosym}             % official EUR-Symbol
\RequirePackage{titling}             % Additional options for Titlepage
%\RequirePackage{indentfirst}        % Indentation
\RequirePackage{hyperref}            % PDF settings


%
% Official RGB colors for diffrent departments
%
\definecolor{fiw}{RGB}{0, 177, 219}
\definecolor{fww}{RGB}{51, 153, 51}
\definecolor{fg}{RGB}{255, 93, 2}
\definecolor{all}{RGB}{47, 50, 41}
\definecolor{silver}{RGB}{175, 175, 175}
\definecolor{lsilver}{RGB}{240, 240, 240}
\definecolor{wings}{RGB}{0,0,150}
\definecolor{dgreen}{rgb}{0.0,0.3,0.0}
\definecolor{dblue}{rgb}{0.0,0.0,0.3}

%
% Packgae configuration
%
\geometry{
	inner=3cm,
	outer=3cm,
	top=3cm,
	bottom=3cm
}
\hypersetup{
	unicode=true, 
	bookmarks=true, 
	bookmarksnumbered=false, 
	bookmarksopen=false, 
	breaklinks=false, 
	pdfborder={0 0 0},	
	backref=false, 
	colorlinks=false, 
	pdftitle={Thomas\ Jonitz}, 
	pdfauthor={t.j.}
}
\lstset{
    backgroundcolor={\color{lsilver}},   
    breakatwhitespace=false,
    showspaces=false,
    showstringspaces=false, 
    basicstyle={\footnotesize\ttfamily\color{black}},                          
    commentstyle={\footnotesize\ttfamily\color{darkgray}},                              
    keywordstyle={\footnotesize\ttfamily\color{dblue}},       
    numberstyle={\footnotesize\ttfamily\color{black}},       
    stringstyle={\footnotesize\ttfamily\color{dgreen}},  
%    title={Src: \lstname},                  
    breaklines={true}, 
    captionpos={b}, 
    frame={l},
    numbers=left,       
    stepnumber=1,                   
    numbersep=10pt,
    tabsize=2,
    xleftmargin=2em
}
\algrenewtext{Function}[2]{\algorithmicfunction\ \texttt{#1}( #2 ):}
\algrenewtext{Procedure}[2]{\algorithmicprocedure\ \texttt{#1}( #2 ):}

%
% Configuring commands
%
\newcounter{RomanPages} 
\renewcommand{\nomname}{Nomenklatur}
\setlength{\nomlabelwidth}{.25\hsize}
\renewcommand{\nomlabel}[1]{#1 \dotfill}
\setlength{\nomitemsep}{-\parsep}
\setlength{\parskip}{5pt}


%
% Additional commands and symbols
%
%\providecommand{\printnomenclature}{\printglossary}
%\providecommand{\makenomenclature}{\makeglossary}
\providecommand{\Quote}[1]{\textit{\glqq #1\grqq\ }}
\providecommand{\Registered}[1]{#1\;\textsuperscript{\textregistered}}
\providecommand{\Trademark}[1]{#1\;\textsuperscript{\texttrademark}}
\providecommand{\Copyright}[1]{{\textcopyright\;#1}}
\providecommand{\Copyleft}[1]{{\textcopyleft\;#1}}
\providecommand{\Euro}[1]{\EUR{#1}}
\providecommand{\Celsius}[1]{$#1\;^\circ\text{C}$}
\providecommand{\Ohm}[1]{$#1\;\Omega$}
\providecommand{\Image}[5][0.9]{
	\begin{figure}[tbp]	
	\begin{center}
	\includegraphics[width=#1\textwidth]{#2}
	\caption{#3}
	\small{#4}
	\label{#5}
	\end{center}
	\end{figure}
}
\providecommand{\FrontMatter}{
	\clearpage
	\singlespacing
	\pagenumbering{Roman}
	\setcounter{RomanPages}{1} 
}
\providecommand{\MainMatter}{
	\setcounter{RomanPages}{\value{page}}
	\clearpage
	\onehalfspacing
	\pagenumbering{arabic}
}
\providecommand{\BackMatter}{
	\clearpage
	\singlespacing
	\pagenumbering{roman}
	\setcounter{page}{\value{RomanPages}+1}
}

