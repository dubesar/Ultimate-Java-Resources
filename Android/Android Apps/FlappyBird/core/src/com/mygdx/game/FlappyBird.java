package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

import sun.rmi.runtime.Log;

public class FlappyBird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background; //texture is nothing but an image
	Texture[] bird;
	Texture topTube , bottomTube;
	int flapState = 0 ; //to change the flapping pictures one after another

	//for the position and velocity of the bird falling due to gravity
	float birdY = 0;//only the Y will be changed
	float velocity = 0;

	int gameState = 0 ;//to set gravity in the game
	float gravity = 2 ; //how much gravity to put in
	float gap = 400; // gap between tubes
	float maxTubeOffset ; //amount that the tubes are moved up or down
	Random random; //for randomizing the gap of the pipes
	float tubeVelocity = 4; //moving veloity of tubes

	//we need to create 4 sets of tubes and we would reset thhem when they cross to the left of the screen
	//we need to spearate them half of the screen width apart
	int numberOfTubes = 4 ;
	float[] tubeX = new float[numberOfTubes];//movemnt of tubes to the left
	float[] tubeOffset = new float[numberOfTubes];
	float distanceBetweenTubes;

	//for collision dectection we need to give shapes to the tube and the bird
	Circle birdCircle ;
	Rectangle[] bottomRectangle,topRectangle;
	ShapeRenderer shapeRenderer;

	//for the scoring
	int score = 0;
	int scoringTube = 0 ;

	//to display the score
	BitmapFont font;

	Texture gameOver;

	public void startAgain()
	{
		birdY=Gdx.graphics.getHeight()/2 - bird[flapState].getHeight()/2;

		for (int i =0 ;i<numberOfTubes;i++)
		{
			tubeOffset[i] = (random.nextFloat() -0.5f)*(Gdx.graphics.getHeight() - gap - 200);//random.nextFloat() ---->a number between 0 and 1
			//this gives the  the max and the min value of tube shift

			tubeX[i] = Gdx.graphics.getWidth()/2 -topTube.getWidth()/2 + Gdx.graphics.getWidth() +  i*distanceBetweenTubes;

			topRectangle[i]= new Rectangle();
			bottomRectangle[i] = new Rectangle();

		}
	}

	@Override
	public void create () { //ran once at start
		batch = new SpriteBatch();
		background = new Texture("bg.png"); //creating my background at start
		bird = new Texture[2];
		bird[0]= new Texture("bird.png");
		bird[1] = new Texture("bird2.png");

		topTube = new Texture("toptube.png");
		bottomTube = new Texture("bottomtube.png");
		maxTubeOffset = Gdx.graphics.getHeight()/2 - gap/2 - 100 ;
		random = new Random();
		distanceBetweenTubes = Gdx.graphics.getWidth()*3/4;//distance between tubes are 3 quarters of the screen width

		shapeRenderer = new ShapeRenderer();
		birdCircle = new Circle();
		bottomRectangle = new Rectangle[numberOfTubes];
		topRectangle = new Rectangle[numberOfTubes];
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		font.getData().setScale(10); // how large the font is

		gameOver = new Texture("over.png");

		startAgain();
	}

	@Override
	public void render ()  //runs continuously
	{
		batch.begin();
		batch.draw(background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()); //draw my background and making it fullscreen
		batch.draw(bird[flapState], Gdx.graphics.getWidth()/2  - bird[flapState].getHeight()/2,birdY);

		//to give the bird an appearance of flapping its wings
		if (flapState == 0)
			flapState=1;
		else
			flapState =0;


		if (gameState ==1) {

			//to establish the scoring system
			if (tubeX[scoringTube] < Gdx.graphics.getWidth()/2)//if the tube has moved to the left of the center of screen
			{
				score++;
				if (scoringTube < numberOfTubes - 1)
					scoringTube++;
				else
					scoringTube = 0 ;
			}
			if (Gdx.input.justTouched()) // to push the bird up
			{
				velocity = -20;

			}



			for (int i =0 ;i<numberOfTubes;i++)
			{
				//check to see if the tubes are going to the left of the screen ,,then we will bring them to the right again
				if (tubeX[i] < - topTube.getWidth()) {
					tubeX[i] = tubeX[i] + (numberOfTubes * distanceBetweenTubes);
					tubeOffset[i] = (random.nextFloat() -0.5f)*(Gdx.graphics.getHeight() - gap - 200);//Offsets change when the a tube crosses the left of screen

				}
				else
					{
					tubeX[i] = tubeX[i] - tubeVelocity;
					}

				batch.draw(topTube,tubeX[i],Gdx.graphics.getHeight()/2 + gap/2  + tubeOffset[i]);
				batch.draw(bottomTube,tubeX[i]   ,Gdx.graphics.getHeight()/2  - gap/2 - bottomTube.getHeight() + tubeOffset[i] );

				//displaying the font
				font.draw(batch , String.valueOf(score) ,100,200);


			}
			if (birdY > 0) { // makes the bird stop dissappearing from the bottom of the screen
				//increase velocity each time a render is called
				velocity = velocity + gravity;
				birdY = birdY - velocity;
			}
			else
				gameState = 2 ;
		}
		else if (gameState == 0)
		{
			if (Gdx.input.justTouched())//logs message when touched
			{
				gameState=1;
			}
		}
		else if (gameState ==2)
		{
			batch.draw(gameOver , Gdx.graphics.getWidth()/2 - gameOver.getWidth()/2 , Gdx.graphics.getHeight()/2 - gameOver.getHeight()/2);
			font.draw(batch , String.valueOf(score) ,100,200);

			if (Gdx.input.justTouched())//logs message when touched
			{
				gameState=1;
				startAgain();
				velocity = 0;
				score = 0;
				scoringTube = 0 ;
			}
		}


		batch.end();

		//x and y coordinate of the circle and the radius
		birdCircle.set(Gdx.graphics.getWidth()/2 , birdY + bird[flapState].getHeight()/2 ,bird[flapState].getHeight()/2 );
		for(int i =0 ; i< numberOfTubes;i++)
		{
			topRectangle[i].set(tubeX[i], Gdx.graphics.getHeight() / 2 + gap / 2 + tubeOffset[i], topTube.getWidth(), topTube.getHeight());
			bottomRectangle[i].set(tubeX[i], Gdx.graphics.getHeight()/2  - gap/2 - bottomTube.getHeight() + tubeOffset[i], topTube.getWidth(), topTube.getHeight());

		}
		//shape rendered just gives color to the shapes
		//shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		//shapeRenderer.setColor(Color.RED);
		//shapeRenderer.circle(birdCircle.x,birdCircle.y,birdCircle.radius);
		for (int j = 0 ; j< numberOfTubes ; j++ )
		{
			//shapeRenderer.rect(topRectangle[j].x,topRectangle[j].y,topRectangle[j].width,topRectangle[j].getHeight());
			//shapeRenderer.rect(bottomRectangle[j].x,bottomRectangle[j].y,bottomRectangle[j].width,bottomRectangle[j].getHeight());

			//check to see if the circle and the rectangle intersect
			if(Intersector.overlaps(birdCircle, topRectangle[j]) || Intersector.overlaps(birdCircle,bottomRectangle[j]))
			{
				//Gdx.app.log("MEssage " , "Yes");
				//gameover is given by the the gamestate of 2
				gameState = 2;

			}

		}
		//shapeRenderer.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();

	}
}
