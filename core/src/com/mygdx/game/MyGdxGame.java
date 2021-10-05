package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyGdxGame extends ApplicationAdapter {
	Stage stage;
	
	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		int Help_Guides = 12;
		int row_height = Gdx.graphics.getWidth() / 12;
		int col_width = Gdx.graphics.getWidth() / 12;

		FreeTypeFontGenerator generator_jp = new FreeTypeFontGenerator(Gdx.files.internal("jp_subset.ttf"));

		FreeTypeFontGenerator.FreeTypeFontParameter parameter_jp = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter_jp.size = 120;
		parameter_jp.borderWidth = 1;
		parameter_jp.color = Color.YELLOW;
		parameter_jp.shadowOffsetX = 3;
		parameter_jp.shadowOffsetY = 3;
		parameter_jp.shadowColor = new Color(0, 0.5f, 0, 0.75f);
		String allChars = LanguagesManager.getLanguageChars("jp");
		parameter_jp.characters = allChars;
		BitmapFont font25 = generator_jp.generateFont(parameter_jp);
		generator_jp.dispose();

		Label.LabelStyle labelStyle_jp = new Label.LabelStyle();
		labelStyle_jp.font = font25;

		assert allChars != null;
		String firstFewChars = allChars.substring(0, 25);

		Label label3 = new Label(firstFewChars,labelStyle_jp);
		label3.setSize((float) Gdx.graphics.getWidth() / Help_Guides * 5, row_height);
		label3.setPosition(col_width*2,Gdx.graphics.getHeight()-row_height*4);
		stage.addActor(label3);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}
}
