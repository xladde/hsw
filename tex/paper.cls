%
% HSW SCRARTCL
%
% Plain TeX class for scientific documents at the 
% University of applied Sciences: Technology, Business and Design Wismar
%
% Author:    tj
% Version:   2014-07-29
%
\LoadClass[papersize=a4paper, fontsize=11pt]{article}
\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{paper}[2014/08/20 Custom class for KOMA-Articles]

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
\RequirePackage{makeidx}             % index generation
\RequirePackage[intoc]{nomencl}      % nomenclature settings
\RequirePackage{setspace}            % Linespacing
\RequirePackage{float}               % floating objects
\RequirePackage{caption}             % caption inside multifloat
\RequirePackage{graphicx}            % image support (float)
\RequirePackage{listings}            % display sourcecode
\RequirePackage{lipsum}              % generate lipsum
\RequirePackage{cclicenses}          % CC-Icons
\RequirePackage{algorithm}           % Algorithm enviroment
\RequirePackage{algpseudocode}       % Enviroment for Pseudo Code
\RequirePackage{eurosym}             % official EUR-Symbol
%\RequirePackage{indentfirst}        % Indentation
\RequirePackage{hyperref}            % PDF settings