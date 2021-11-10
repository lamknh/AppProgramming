package com.example.kakaomap

import android.Manifest
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.security.MessageDigest
import android.content.pm.PackageManager
import android.location.LocationManager
import android.net.Uri
import android.provider.Settings
import android.util.Base64
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import net.daum.mf.map.api.CalloutBalloonAdapter
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import net.daum.mf.map.api.MapPOIItem
import java.util.ArrayList








class MainActivity : AppCompatActivity() {
    private val ACCESS_FINE_LOCATION = 1000     // Request Code

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapView = MapView(this)

        mapView.setCalloutBalloonAdapter(CustomBalloonAdapter(layoutInflater))  // 커스텀 말풍선 등록

        // 중심점 변경
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(35.8888, 128.6103), true)
        // 중심점 변경 + 줌 레벨 변경
        //mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(33.41, 126.52), 9, true)
        // 줌 인
        mapView.zoomIn(true);

        // 줌 아웃
        mapView.zoomOut(true);


        //test Class
        val testGIO1 = TestGIO("test1", "description1",35.8888, 128.6103)
        val testGIO2 = TestGIO("test2", "description2", 35.89302375678098, 128.60956210965904)

        // 마커 추가
        val marker = MapPOIItem()

        marker.apply {
                itemName = testGIO1.name   // 마커 이름
                mapPoint = MapPoint.mapPointWithGeoCoord(testGIO1.latitude, testGIO1.longitude)   // 좌표
                markerType = MapPOIItem.MarkerType.BluePin          // 마커 모양 (커스텀)
                //customImageResourceId = R.drawable.이미지               // 커스텀 마커 이미지
                selectedMarkerType = MapPOIItem.MarkerType.RedPin  // 클릭 시 마커 모양 (커스텀)
                //customSelectedImageResourceId = R.drawable.이미지       // 클릭 시 커스텀 마커 이미지
                isCustomImageAutoscale = false      // 커스텀 마커 이미지 크기 자동 조정
                setCustomImageAnchor(0.5f, 1.0f)    // 마커 이미지 기준점
                mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(testGIO1.latitude, testGIO1.longitude), true)
            }
        mapView.addPOIItem(marker)

        val marker2 = MapPOIItem()
        marker2.apply {
            itemName = testGIO2.name   // 마커 이름
            mapPoint = MapPoint.mapPointWithGeoCoord(testGIO2.latitude, testGIO2.longitude)   // 좌표
            markerType = MapPOIItem.MarkerType.BluePin          // 마커 모양 (커스텀)
            //customImageResourceId = R.drawable.이미지               // 커스텀 마커 이미지
            selectedMarkerType = MapPOIItem.MarkerType.RedPin  // 클릭 시 마커 모양 (커스텀)
            //customSelectedImageResourceId = R.drawable.이미지       // 클릭 시 커스텀 마커 이미지
            isCustomImageAutoscale = false      // 커스텀 마커 이미지 크기 자동 조정
            setCustomImageAnchor(0.5f, 1.0f)    // 마커 이미지 기준점
            mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(testGIO2.latitude, testGIO2.longitude), true)
        }
        mapView.addPOIItem(marker2)

        val mapViewContainer = findViewById<View>(R.id.map_view) as ViewGroup
        mapViewContainer.addView(mapView)
    }

    // 커스텀 말풍선 클래스
    class CustomBalloonAdapter(inflater: LayoutInflater): CalloutBalloonAdapter {
        val mCalloutBalloon: View = inflater.inflate(R.layout.balloon_layout, null)
        val name: TextView = mCalloutBalloon.findViewById(R.id.ball_tv_name)
        //val address: TextView = mCalloutBalloon.findViewById(R.id.ball_tv_address)

        override fun getCalloutBalloon(poiItem: MapPOIItem?): View {
            // 마커 클릭 시 나오는 말풍선
            name.text = poiItem?.itemName   // 해당 마커의 정보 이용 가능
            //address.text = "설명"
            return mCalloutBalloon
        }

        override fun getPressedCalloutBalloon(poiItem: MapPOIItem?): View {
            // 말풍선 클릭 시
            return mCalloutBalloon
        }
    }

    private fun getAppKeyHash() { // 앱 해시값 얻기
        try {
            val info =
                packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                var md: MessageDigest
                md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                val something = String(Base64.encode(md.digest(), 0))
                Log.e("Hash key", something)
            }
        } catch (e: Exception) {

            Log.e("name not found", e.toString())
        }
    }
}