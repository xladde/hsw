#!/bin/bash

curl -s cdp.pca.dfn.de/telekom-root-ca-2/pub/cacert/cacert.pem \
cdp.pca.dfn.de/global-root-ca/pub/cacert/cacert.pem \
cdp.pca.dfn.de/hsw-ca/pub/cacert/g_cacert.pem > hsw-ca-chain.pem 
