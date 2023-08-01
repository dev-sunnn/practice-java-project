package com.example.app.controller;

/**
 * 応用：Spring Boot で Webアプリ（１）
 */
public class Practice16 {
    /** practice 1 */
    // １：@Transactionalのアノテーションはpublicメソッドにつける。
    // publicのメソッドにアノテーションを付与した場合のみ、ロールバックが有効になります。
    // （privateも、protectedも、パッケージプライベートもNGです。）
    // ２：@Transactionalのアノテーションをつけたメソッドは、別のクラスから呼び出す。
    // 同じクラスからの呼び出しでは、publicのメソッドでもロールバックされません。
    // また、Springの機能を使ったロールバックなので、単なるドメインクラスからの呼び出しもNGです。
    // サンプルソースのように Controller から Service を呼び出す。や、Service から Component を呼び出す。という場合に使いましょう。
}
