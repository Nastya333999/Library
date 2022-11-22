package com.app.mylibrary

import android.content.res.Resources
import android.net.Uri.encode
import androidx.core.net.toUri
import java.util.*

class UrlBuilder {
    companion object {
        fun buildUrl(
            res: Resources, baseFileData: String,
            gadid: String, apps: MutableMap<String, Any>?,
            deep: String, uid: String?,
            secure_get_parametr: Int,
            secure_key: Int,
            dev_tmz_key: Int,
            gadid_key: Int,
            deeplink_key: Int,
            source_key: Int,
            af_id_key: Int,
            adset_id_key: Int,
            campaign_id_key: Int,
            app_campaign_key: Int,
            adset_key: Int,
            adgroup_key: Int,
            orig_cost_key: Int,
            af_siteid_key: Int
        ): String {
            var url = "$baseFileData?"
            url += createPArametr(
                res.getString(secure_get_parametr),
                res.getString(secure_key)
            ) + "&"

            url += createPArametr(
                res.getString(dev_tmz_key),
                TimeZone.getDefault().id
            ) + "&"

            url += createPArametr(
                res.getString(gadid_key),
                gadid
            ) + "&"

            url += createPArametr(
                res.getString(deeplink_key),
                deep
            ) + "&"

            url += createPArametr(
                res.getString(source_key),
                if (deep != "null") "deeplink" else apps?.get("media_source").toString()
            ) + "&"

            url += createPArametr(
                res.getString(af_id_key),
                uid
            ) + "&"

            url += createPArametr(
                res.getString(adset_id_key),
                apps?.get("adset_id").toString()
            ) + "&"

            url += createPArametr(
                res.getString(campaign_id_key),
                apps?.get("campaign_id").toString()
            ) + "&"

            url += createPArametr(
                res.getString(app_campaign_key),
                apps?.get("campaign").toString()
            ) + "&"

            url += createPArametr(
                res.getString(adset_key),
                apps?.get("adset").toString()
            ) + "&"

            url += createPArametr(
                res.getString(adgroup_key),
                apps?.get("adgroup").toString()
            ) + "&"

            url += createPArametr(
                res.getString(orig_cost_key),
                apps?.get("orig_cost").toString()
            ) + "&"

            url += createPArametr(
                res.getString(af_siteid_key),
                apps?.get("af_siteid").toString()
            )

            return "https://$url"
        }


        private fun createPArametr(key: String?, value: String?): String {

            return (encode(key, null).toString() + "="
                    + encode(value, null))
        }


    }
}