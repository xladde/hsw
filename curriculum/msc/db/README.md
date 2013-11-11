# Datenbanken in Unternehmen (WI-Ma-1)
## Verbindung/Interaktion mit DB

Über bestehende VPN-Verbindung:
```sh
$ ssh <server-username>@172.20.14.212
$ sqlplus <db-username>@eval112 /nolog
```

Über Rothko:

```sh
$ ssh <server-username@rothko.wi.hs-wismar.de>
$ sqlplus <db-username>/<db-pw>@172.20.14.212/eval112
```

Über Webzugriff:
	https://172.20.14.212:1158/em

bzw von DB-Server:
	https://localhost:1158/em

	
