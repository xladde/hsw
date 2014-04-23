\LoadClass[papersize=a4paper, fontsize=11pt]{amsart}
\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{vertrag}[2014-04 Vertragsklasse (alpha)]

\RequirePackage{fixltx2e}           % fix latex
\RequirePackage[utf8]{inputenc}     % inputencryption
\RequirePackage[T1]{fontenc}        % fontencryption
\RequirePackage[ngerman]{babel}     % language package
\RequirePackage[numbers]{natbib}    % bibliography

\RequirePackage[margin=3cm]{geometry}           % page margins

\RequirePackage{setspace}           % Linespacing
\RequirePackage{float}              % floating objects
\RequirePackage{caption}            % caption inside multifloat
\RequirePackage{graphicx}           % image support (float)

\RequirePackage{lipsum}             % generate lipsum

%\RequirePackage{eurosym}            % official EUR-Symbol
%\RequirePackage{hyperref}           % PDF settings


\renewcommand{\thesection}{\S~\arabic{section}}
\renewcommand{\thesubsection}{\arabic{subsection}}
\renewcommand{\thesubsubsection}{\hspace{2em}\alph{subsubsection}}

\providecommand{\Paragraph}[2]{\section{#1\label{#2}}}
\providecommand{\Absatz}[1]{\subsection{\label{#1}}}
\providecommand{\Nummer}[1]{\subsubsection{\label{#1}}}

