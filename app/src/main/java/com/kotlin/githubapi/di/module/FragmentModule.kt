package com.strikepros.alphaone.di.module

import com.strikepros.alphaone.ui.battle.radar.RadarFragment
import com.strikepros.alphaone.ui.battlealert.BattleAlertFragment
import com.strikepros.alphaone.ui.battlealert.BattleAlertUserFragment
import com.strikepros.alphaone.ui.createbattle.editvenuename.EditVenueNameFragment
import com.strikepros.alphaone.ui.createbattle.findplayers.FindPlayersFragment
import com.strikepros.alphaone.ui.createbattle.rules.RulesFragment
import com.strikepros.alphaone.ui.createbattle.selectvenue.SelectVenueFragment
import com.strikepros.alphaone.ui.createbattle.startnewgame.StartGameFragment
import com.strikepros.alphaone.ui.findplayers.views.InviteAvailableFragment
import com.strikepros.alphaone.ui.findplayers.views.InvitePendingFragment
import com.strikepros.alphaone.ui.findplayers.views.InviteRecentFragment
import com.strikepros.alphaone.ui.leaderboard.TabLeaderboardFragment
import com.strikepros.alphaone.ui.progress.ProgressFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created on 08.02.2018.
 */

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun findPlayersFragment(): FindPlayersFragment

    @ContributesAndroidInjector
    internal abstract fun startNewGameFragment(): StartGameFragment

    @ContributesAndroidInjector
    internal abstract fun rulesFragment(): RulesFragment

    @ContributesAndroidInjector
    internal abstract fun selectVenueFragment(): SelectVenueFragment

    @ContributesAndroidInjector
    internal abstract fun editVenuNameFragment(): EditVenueNameFragment

    @ContributesAndroidInjector
    internal abstract fun progressFragment(): ProgressFragment

    @ContributesAndroidInjector
    internal abstract fun radarFragment(): RadarFragment

    @ContributesAndroidInjector
    internal abstract fun battleAlertFragment(): BattleAlertFragment

    @ContributesAndroidInjector
    internal abstract fun inviteAvailableFragment(): InviteAvailableFragment

    @ContributesAndroidInjector
    internal abstract fun inviteRecentFragment(): InviteRecentFragment

    @ContributesAndroidInjector
    internal abstract fun invitePendingFragment(): InvitePendingFragment

    @ContributesAndroidInjector
    internal abstract fun battleAlertUserFragment(): BattleAlertUserFragment

    @ContributesAndroidInjector
    internal abstract fun tabLeadreboardFragment(): TabLeaderboardFragment

}