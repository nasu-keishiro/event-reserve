#プロジェクト概要

-JSP/Servlet/DBを使ったWEBアプリケーション

-イベントの予約管理を行うアプリ

-ユーザー側は予約したイベントの再確認、管理者側はイベント及び予約者の情報の閲覧が可能

#ページ構成

| ページ | URL | Servlet | JSP |
|:------:|:----|--------:|:------|
| ログイン | /login | LoginServlet | login.jsp |
| イベントリスト | /eventList |EventListServlet | eventList.jsp |
| イベント作成 | /addEvent | AddEventServlet | eventAdd.jsp |
| 各イベント詳細 | /reserveMonthList | ReserveMonthListServlet | reserveMonthList.jsp |
| イベント一覧 | /event | EventServlet | event.jsp |
| 予約Form | /reserve | ReserveServlet | reserveForm.jsp |
| 予約イベント確認 | /reserveConfirmation | ReserveConfirmationServlet | reserveConfirmationDone.jsp |

