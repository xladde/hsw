\LoadClass{beamer}
\mode<presentation>
\usetheme{default}
%\usetheme[height=25mm]{Rochester}
\usecolortheme[RGB={0,50,95}]{structure}
\useoutertheme{infolines}

\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{hswbeamer}[2013/08/20 Custom class for Presentatins]

\RequirePackage{fixltx2e}           % fix latex
\RequirePackage[ngerman]{babel}     % language package
\RequirePackage[utf8]{inputenc}    % inputencryption
\RequirePackage[T1]{fontenc}        % fontencryption
\RequirePackage{pgf}
\RequirePackage{amsmath}            % math symbols etc
\RequirePackage{amssymb}            % math symbols

\RequirePackage{makeidx}            % index generation
\RequirePackage[intoc]{nomencl}     % nomenclature settings

\RequirePackage{setspace}           % Linespacing
\RequirePackage{float}              % floating objects
\RequirePackage{caption}            % caption inside multifloat
\RequirePackage{graphicx}           % image support (float)
\RequirePackage{atbegshi}
\RequirePackage{listings}           % display sourcecode

\RequirePackage{multicol}           % paragraph columns
\RequirePackage{lipsum}             % generate lipsum
\RequirePackage{cclicenses}         % CC-Icons

\RequirePackage{xcolor}             % use colors
\RequirePackage{tikz}               % insert logo to head

\RequirePackage{algorithm}
\RequirePackage{algpseudocode}

\RequirePackage{lmodern}            % something about font etc...
\RequirePackage{libertine}          % use Libertine fontset
\RequirePackage{eurosym}            % official EUR-Symbol

\RequirePackage{geometry}
\RequirePackage{hyperref}
\RequirePackage{xkeyval}

\setbeamertemplate{section in head/foot}{\hfill\insertsectionheadnumber.~\insertsectionhead}
\setbeamertemplate{section in head/foot shaded}{\color{structure!50}\hfill\insertsectionheadnumber.~\insertsectionhead}
\setbeamertemplate{section in toc}{\inserttocsectionnumber.~\inserttocsection}

\geometry{left=1cm, right=1cm}
\hypersetup{colorlinks=false}

%
% CONFIG
%
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


\definecolor{lgray}{rgb}{0.95,0.95,0.95}
\definecolor{dgreen}{rgb}{0.0,0.3,0.0}
\definecolor{dblue}{rgb}{0.0,0.0,0.3}
\definecolor{wings}{RGB}{0,50,95}
\definecolor{fiw}{RGB}{0, 177, 219}
\definecolor{fww}{RGB}{51, 153, 51}
\definecolor{fg}{RGB}{255, 93, 2}
\definecolor{all}{RGB}{47, 50, 41}
\definecolor{silver}{RGB}{175, 175, 175}
\definecolor{lsilver}{RGB}{240, 240, 240}
\definecolor{wings}{RGB}{0,50,95}
\definecolor{dgreen}{rgb}{0.0,0.3,0.0}
\definecolor{dblue}{rgb}{0.0,0.0,0.3}

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
\providecommand{\Code}[2]{\lstinputlisting[language=Java, caption=#2]{#1}}
\providecommand{\Item}[2]{\item{\textbf{#1:~}#2}}

\providecommand{\Image}[4][0.9]{
    \begin{figure}[tbp]
    \begin{center}
    \includegraphics[width=#1\textwidth]{#2}
    \caption{#3}
    \small{#4}
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

\providecommand{\TitleFrame}[1]{
    \section{#1}
    \begin{frame}{#1}
        \begin{center}
            \Huge{#1}
        \end{center}
    \end{frame}
}


\institute[HS Wismar]{Hochschule Wismar -- University of Applied Sciences: Technology, Business and Design\\Fakult\"{a}t f\"{u}r Wirtschaftswissenschaften}
%\titlegraphic{\includegraphics[scale=0.05]{hsw-wings.jpg}}

\beamertemplatenavigationsymbolsempty

\addtobeamertemplate{frametitle}{}{%
\begin{tikzpicture}[remember picture,overlay]
\node[anchor=north east,yshift=-15pt,xshift=-15pt] at (current page.north east) {\includegraphics[scale=0.1]{img/fischer-wings.png}};
\end{tikzpicture}}