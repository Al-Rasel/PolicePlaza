package plaza.police.rasel.policeplaza;

import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.enter, R.anim.exit);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video);
        videoView = (VideoView) findViewById(R.id.videoView);

        getWindow().setFormat(PixelFormat.UNKNOWN);

        String uriPath2 = "android.resource://plaza.police.rasel.policeplaza/"+R.raw.vid;
        Uri uri2 = Uri.parse(uriPath2);
        videoView.setVideoURI(uri2);
        videoView.requestFocus();
        videoView.start();

/*
*
* Button buttonPlayVideo2 = (Button)findViewById(R.id.button1);
getWindow().setFormat(PixelFormat.UNKNOWN);
//displays a video file
VideoView mVideoView2 = (VideoView)findViewById(R.id.videoView1);
String uriPath2 = "android.resource://com.example.toyo.playvideo/"+R.raw.movie;
Uri uri2 = Uri.parse(uriPath2);
mVideoView2.setVideoURI(uri2);
mVideoView2.requestFocus();
mVideoView2.start();
buttonPlayVideo2.setOnClickListener(new Button.OnClickListener() {
@Override
public void onClick(View v) {
VideoView mVideoView2 = (VideoView) findViewById(R.id.videoView1);
// VideoView mVideoView = new VideoView(this);
String uriPath = "android.resource://com.example.toyo.playvideo/" + R.raw.movie;
Uri uri2 = Uri.parse(uriPath);
mVideoView2.setVideoURI(uri2);
mVideoView2.requestFocus();
mVideoView2.start();
}
});
*
* */
    }
}
