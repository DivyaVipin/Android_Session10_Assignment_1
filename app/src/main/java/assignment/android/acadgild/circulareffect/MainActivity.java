package assignment.android.acadgild.circulareffect;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btnClick;
    LinearLayout layoutVersions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClick=(Button)findViewById(R.id.btnClick);
        layoutVersions=(LinearLayout)findViewById(R.id.androidVersions);
        layoutVersions.setVisibility(View.INVISIBLE);
        btnClick.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(btnClick.getText().equals("Click me")) {
            int cx = (layoutVersions.getLeft() + layoutVersions.getRight());
            int cy = (layoutVersions.getTop());
            int startradius = 0;
            int endradius = Math.max(layoutVersions.getWidth(), layoutVersions.getHeight());
            Animator animator = ViewAnimationUtils.createCircularReveal(layoutVersions, cx, cy, startradius, endradius);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setDuration(400);
            layoutVersions.setVisibility(View.VISIBLE);
            animator.start();
            btnClick.setText("Close me");
        }
        else
        {
            int cx = (layoutVersions.getLeft() + layoutVersions.getRight());
            int cy = (layoutVersions.getTop());
            int startradius = 0;
            int endradius = Math.max(layoutVersions.getWidth(), layoutVersions.getHeight());
            Animator animator = ViewAnimationUtils.createCircularReveal(layoutVersions, cx, cy,endradius,startradius);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setDuration(800);
            layoutVersions.setVisibility(View.INVISIBLE);
            animator.start();
            btnClick.setText("Click me");
        }
    }
}
