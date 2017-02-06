%
%   LaTeX-Class for Presentations 
%   (e.g. at HSW)
%
%   author(s):  xld (info@xladde.de)
%               
%   changelog: 
%       2013-08-20:   * initial
%       2017-02-06    * inserted options for diffrent departments
%   license:    GNU GENERAL PUBLIC LICENSE v3
%               http://www.gnu.org/licenses/gpl-3.0.html    
%
\LoadClass[aspectratio=169]{beamer} %1610, 149, 54, 32 und 43 for 16:10, 14:9, 5:4, 3:2 und 4:3.
\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{hswbeamer}[2013/08/20 Custom class for Presentations]

\newcommand{\baseColor}{black}
\newcommand{\baseImage}{img/fischer-light.png}
\newcommand{\baseColorRGBCode}{47, 50, 41}
\newcommand{\instituteTitle}{Hochschule Wismar}
\newcommand{\instituteTitleShort}{HSW}

%
% DEPARTMENT SPECIFIC CONFIGURATIONS
%
\DeclareOption{fww}{
    \renewcommand{\instituteTitle}{Hochschule Wismar -- Fakult\"{a}t f\"{u}r Wirtschaftswissenschaften}
    %\renewcommand{\instituteTitleShort}{HSW}
    \renewcommand{\baseColorRGBCode}{51, 153, 51}
    \renewcommand{\baseImage}{img/fischer-fww.png}
    \renewcommand{\baseColor}{fww}
}
\DeclareOption{fiw}{
    \renewcommand{\instituteTitle}{Hochschule Wismar -- Fakult\"{a}t f\"{u}r Ingenieurswissenschaften}
    \renewcommand{\baseColorRGBCode}{0,177,219}
    \renewcommand{\baseImage}{img/fischer-fiw.png}
    \renewcommand{\baseColor}{fiw}
}
\DeclareOption{fg}{
    \renewcommand{\instituteTitle}{Hochschule Wismar -- Fakult\"{a}t Gestaltung}
    \renewcommand{\baseColorRGBCode}{255,93,2}
    \renewcommand{\baseImage}{img/fischer-fg.png}
    \renewcommand{\baseColor}{fg}
}
\DeclareOption{dark}{
    \renewcommand{\baseColorRGBCode}{47,50,41}
    \renewcommand{\baseImage}{img/fischer-dark.png}
    \renewcommand{\baseColor}{all}
}
\DeclareOption{light}{
    \renewcommand{\baseColorRGBCode}{175,175,175}
    \renewcommand{\baseImage}{img/fischer-light.png}
    \renewcommand{\baseColor}{silver}
}
\DeclareOption{wings}{
    \renewcommand{\instituteTitle}{Wismar International Graduation Services GmbH}
    \renewcommand{\instituteTitleShort}{WINGS GmbH}
    \renewcommand{\baseColorRGBCode}{0,50,95}
    \renewcommand{\baseImage}{img/fischer-wings.png}
    \renewcommand{\baseColor}{wings}
}
\DeclareOption*{
    \renewcommand{\baseColorRGBCode}{wings}
    \renewcommand{\baseImage}{img/fischer-dark.png}
    \renewcommand{\baseColor}{all}
}

\ProcessOptions
\relax

%
% IMPORTS
%
%\RequirePackage{fixltx2e}           % fix latex
\RequirePackage[utf8]{inputenc}     % inputencryption
\RequirePackage[T1]{fontenc}        % fontencryption
\RequirePackage[ngerman]{babel}     % language package
%\RequirePackage{natbib}            % bibliography
%\RequirePackage[numbers]{biblatex}
\RequirePackage{pgf}
\RequirePackage{amsmath}            % math symbols etc
\RequirePackage{amssymb}            % math symbols

\RequirePackage{makeidx}            % index generation
\RequirePackage[intoc]{nomencl}     % nomenclature settings
\RequirePackage{nameref}
\RequirePackage{setspace}           % Linespacing
\RequirePackage{float}              % floating objects
\RequirePackage{caption}            % caption inside multifloat
\RequirePackage{graphicx}           % image support (float)
\RequirePackage{atbegshi}
\RequirePackage{listings}           % display sourcecode

\RequirePackage{multicol}           % paragraph columns
\RequirePackage{lipsum}             % generate lipsum
\RequirePackage{cclicenses}         % CC-Icons


\RequirePackage{tikz}               % insert logo to head

\RequirePackage{algorithm}
\RequirePackage{algpseudocode}

\RequirePackage{lmodern}            % something about font etc...
\RequirePackage{libertine}          % use Libertine fontset
\RequirePackage{eurosym}            % official EUR-Symbol

\RequirePackage{geometry}
\RequirePackage{hyperref}
\RequirePackage{xkeyval}
\RequirePackage{xcolor}             % use colors
\definecolor{lgray}{rgb}{0.95,0.95,0.95}
\definecolor{dgreen}{rgb}{0.0,0.3,0.0}
\definecolor{dblue}{rgb}{0.0,0.0,0.3}
\definecolor{wings}{RGB}{0,50,95}
\definecolor{fiw}{RGB}{0,177,219}
\definecolor{fww}{RGB}{51, 153, 51}
\definecolor{fg}{RGB}{255, 93, 2}
\definecolor{all}{RGB}{47, 50, 41}
\definecolor{silver}{RGB}{175, 175, 175}
\definecolor{lsilver}{RGB}{240, 240, 240}
\definecolor{dgreen}{rgb}{0.0,0.3,0.0}
\definecolor{dblue}{rgb}{0.0,0.0,0.3}
\definecolor{black}{rgb}{0.0,0.0,0.0}



\mode<presentation>
\usetheme{default}
\usecolortheme[RGB={\baseColorRGBCode}]{structure}%wings
\useoutertheme{infolines}
\beamertemplatenavigationsymbolsempty
%\setbeamertemplate{section in head/foot}{\hfill\insertsectionheadnumber.~\insertsectionhead}
%\setbeamertemplate{section in head/foot shaded}{\color{structure!50}\hfill\insertsectionheadnumber.~\insertsectionhead}
%\setbeamertemplate{section in head/foot shaded}{\hfill\insertsectionheadnumber.~\insertsectionhead}
%\setbeamertemplate{section in toc}{\inserttocsectionnumber.~\inserttocsection}

\institute[\instituteTitleShort]{\instituteTitle}
\titlegraphic{\includegraphics[scale=0.25]{\baseImage}}
\addtobeamertemplate{frametitle}{}{%
    \begin{tikzpicture}[remember picture,overlay]
    \node[anchor=north east,yshift=-15pt,xshift=-15pt] at (current page.north east) {\includegraphics[scale=0.1]{\baseImage}};
    \end{tikzpicture}
}

%
% CONFIG
%



\geometry{left=1cm, right=1cm}
\hypersetup{colorlinks=false}
\addto\captionsngerman{\renewcommand{\figurename}{Abb.}} % change figure text
\addto\captionsngerman{\renewcommand{\tablename}{Tab.}}  % change figure text
\renewcommand{\nomname}{Nomenklatur}
\setlength{\nomlabelwidth}{.25\hsize}
\renewcommand{\nomlabel}[1]{#1 \dotfill}
\setlength{\nomitemsep}{-\parsep}
%
% ADDITIONAL COMMANDS
%
\providecommand{\Quote}[1]{\textit{\glqq #1\grqq\ }}
\providecommand{\Cite}[1]{\textsuperscript{[#1]}}

%
% ADDITIONAL UNITS AND SYMBOLS
%
\providecommand{\Registered}[1]{#1\;\textsuperscript{\textregistered}}
\providecommand{\Trademark}[1]{#1\;\textsuperscript{\texttrademark}}
\providecommand{\Copyright}[1]{{\textcopyright\;#1}}
\providecommand{\Copyleft}[1]{{\textcopyleft\;#1}}
\providecommand{\Euro}[1]{\EUR{#1}}
\providecommand{\Celsius}[1]{$#1\;^\circ\text{C}$}
\providecommand{\Ohm}[1]{$#1\;\Omega$}

\providecommand{\printnomenclature}{\printglossary}
\providecommand{\makenomenclature}{\makeglossary}


\lstset{
    backgroundcolor={\color{lgray}},
    breakatwhitespace=false,
    showspaces=false,
    showstringspaces=false,
    basicstyle={\footnotesize\ttfamily\color{black}},
    commentstyle={\footnotesize\ttfamily\color{darkgray}},
    keywordstyle={\footnotesize\ttfamily\color{dblue}},
    numberstyle={\footnotesize\ttfamily\color{black}},
    stringstyle={\footnotesize\ttfamily\color{dgreen}},
    title={Src: \lstname},
    breaklines={true},
    captionpos={b},
    frame={l},
    numbers=left,
    stepnumber=1,
    numbersep=10pt,
    tabsize=2,
    xleftmargin=2em
}

%
% COMMANDS
%
\providecommand{\Rule}[1][1]{\centerline{\rule[0mm]{#1\columnwidth}{1pt}}}
%\providecommand{\Cite}[3]{\footnote{\citealp[#1][#3]{#2}}}
\providecommand{\Code}[3]{\lstinputlisting[language=C, caption=#2, label={src:#3}]{#1}}
\providecommand{\Item}[2]{\item{\textbf{#1:~}#2}}

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

\algrenewtext{Function}[2]{\algorithmicfunction\ \texttt{#1}( #2 ):}
\algrenewtext{Procedure}[2]{\algorithmicprocedure\ \texttt{#1}( #2 ):}



%
% ADDITIONAL UNITS AND SYMBOLS
%
\providecommand{\Registered}[1]{#1\;\textsuperscript{\textregistered}}
\providecommand{\Trademark}[1]{#1\;\textsuperscript{\texttrademark}}
\providecommand{\Copyright}[1]{{\textcopyright\;#1}}
\providecommand{\Copyleft}[1]{{\textcopyleft\;#1}}
\providecommand{\Euro}[1]{\EUR{#1}}
\providecommand{\Celsius}[1]{$#1\;^\circ\text{C}$}
\providecommand{\Ohm}[1]{$#1\;\Omega$}
\providecommand{\Uhr}[2]{$#1\;^\text{#2}$}
%\providecommand{\currentname}{\@currentlabelname}




\providecommand{\SectionFrame}[2]{
    %\section{#1}
    \begin{frame}{~}
        \begin{center}
            \color{\baseColor}\Huge{#1}\par\bigskip
            \large{#2}\color{black}
        \end{center}
    \end{frame}
}
\providecommand{\SubSectionFrame}[1]{
    %\subsection{#1}
    \begin{frame}
        \begin{center}\color{\baseColor}
            \includegraphics[scale=0.1]{\baseImage}~~~\Large{#1}
        \color{black}\end{center}
    \end{frame}
}