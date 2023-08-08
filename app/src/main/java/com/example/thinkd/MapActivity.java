package com.example.thinkd;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
/* 오류나서 주석처리함 코드 자체 오류인 것으로 추정됨
// AndroidManifest.xml의 activity 정의 부분도 주석처리함 이 코드를 실행하려 할 시 manifest의 주석도 해제하기 바람
public class MapActivity{
    public class Map extends AppCompatActivity implements OnMapReadyCallback {

        private GoogleMap mMap;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_map);

            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }

        public FragmentManager getSupportFragmentManager() {
            ;
            return null;
        }


        @Override
        public void onMapReady(final GoogleMap googleMap) {
            mMap = googleMap;

            LatLng SEOUL = new LatLng(37.56, 126.97);

            MarkerOptions markerOptions = new MarkerOptions();         // 마커 생성
            markerOptions.position(SEOUL);
            markerOptions.title("서울");                         // 마커 제목
            markerOptions.snippet("한국의 수도");         // 마커 설명
            mMap.addMarker(markerOptions);

            mMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));                 // 초기 위치
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15));                         // 줌의 정도
            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);                           // 지도 유형 설정

        }
    }
}

 */