package com.meafocus.memoriakids01pro.fragments;

import androidx.fragment.app.Fragment;

import com.meafocus.memoriakids01pro.events.EventObserver;
import com.meafocus.memoriakids01pro.events.engine.FlipDownCardsEvent;
import com.meafocus.memoriakids01pro.events.engine.GameWonEvent;
import com.meafocus.memoriakids01pro.events.engine.HidePairCardsEvent;
import com.meafocus.memoriakids01pro.events.ui.BackGameEvent;
import com.meafocus.memoriakids01pro.events.ui.FlipCardEvent;
import com.meafocus.memoriakids01pro.events.ui.NextGameEvent;
import com.meafocus.memoriakids01pro.events.ui.ResetBackgroundEvent;
import com.meafocus.memoriakids01pro.events.ui.ThemeSelectedEvent;
import com.meafocus.memoriakids01pro.events.ui.DifficultySelectedEvent;
import com.meafocus.memoriakids01pro.events.ui.StartEvent;

public class BaseFragment extends Fragment implements EventObserver {

	@Override
	public void onEvent(FlipCardEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(DifficultySelectedEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(HidePairCardsEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(FlipDownCardsEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(StartEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(ThemeSelectedEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(GameWonEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(BackGameEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(NextGameEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(ResetBackgroundEvent event) {
		throw new UnsupportedOperationException();
	}

}
