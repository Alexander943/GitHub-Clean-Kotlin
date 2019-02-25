package com.strikepros.alphaone.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.strikepros.alphaone.di.annotation.ViewModelKey
import com.strikepros.alphaone.ui.base.AppViewModelFactory
import com.strikepros.alphaone.ui.battle.BattleViewModel
import com.strikepros.alphaone.ui.battle.radar.RadarViewModel
import com.strikepros.alphaone.ui.battle.signalr.SignalRViewModel
import com.strikepros.alphaone.ui.battlealert.BattleAlertViewModel
import com.strikepros.alphaone.ui.battleoptions.BattleOptionsViewModel
import com.strikepros.alphaone.ui.battlerecord.BattleRecordViewModel
import com.strikepros.alphaone.ui.chat.ChatViewModel
import com.strikepros.alphaone.ui.community.CommunityViewModel
import com.strikepros.alphaone.ui.createbattle.CreateBattleViewModel
import com.strikepros.alphaone.ui.createbattle.editvenuename.EditVenueNameViewModel
import com.strikepros.alphaone.ui.createbattle.selectvenue.SelectVenueViewModel
import com.strikepros.alphaone.ui.createteam.CreateTeamViewModel
import com.strikepros.alphaone.ui.devices.GearPairingViewModel
import com.strikepros.alphaone.ui.editteam.EditTeamViewModel
import com.strikepros.alphaone.ui.eliminate.EliminateViewModel
import com.strikepros.alphaone.ui.emailinfo.EmailInfoViewModel
import com.strikepros.alphaone.ui.findbattle.FindBattleViewModel
import com.strikepros.alphaone.ui.findplayers.views.FindPlayersViewModel
import com.strikepros.alphaone.ui.fullscreenimage.FullscreenImageViewModel
import com.strikepros.alphaone.ui.gameover.GameOverViewModel
import com.strikepros.alphaone.ui.getstarted.GetStartedViewModel
import com.strikepros.alphaone.ui.giftreload.GiftReloadViewModel
import com.strikepros.alphaone.ui.home.HomeViewModel
import com.strikepros.alphaone.ui.magic.MagicViewModel
import com.strikepros.alphaone.ui.map.MapViewModel
import com.strikepros.alphaone.ui.mapsimple.MapSimpleViewModel
import com.strikepros.alphaone.ui.miniprofilestat.MiniProfileStatsViewModel
import com.strikepros.alphaone.ui.notification.NotificationViewModel
import com.strikepros.alphaone.ui.powerbattle.nonorganiser.NonOrganiserBattleViewModel
import com.strikepros.alphaone.ui.powerbattle.organiser.OrganiserBattleViewModel
import com.strikepros.alphaone.ui.profilestats.ProfileStatsOldViewModel
import com.strikepros.alphaone.ui.profilestats.ProfileStatsViewModel
import com.strikepros.alphaone.ui.recording.RecordingViewModel
import com.strikepros.alphaone.ui.register.RegisterViewModel
import com.strikepros.alphaone.ui.selectplayers.SelectPlayersViewModel
import com.strikepros.alphaone.ui.sendreload.SendReloadViewModel
import com.strikepros.alphaone.ui.splash.SplashViewModel
import com.strikepros.alphaone.ui.stats.StatsViewModel
import com.strikepros.alphaone.ui.teamscreated.TeamsCreatedViewModel
import com.strikepros.alphaone.ui.username.UserNameViewModel
import com.strikepros.alphaone.ui.userstats.UserStatsViewModel
import com.strikepros.alphaone.ui.usertag.UserTagViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created on 07.02.2018.
 */

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GetStartedViewModel::class)
    internal abstract fun bindGetStartedViewModel(getStartedViewModel: GetStartedViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserNameViewModel::class)
    internal abstract fun bindUserNameViewModel(registerNameViewModel: UserNameViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    internal abstract fun bindRegisterViewModel(registerViewModel: RegisterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EmailInfoViewModel::class)
    internal abstract fun bindEmailInfoViewModel(emailInfoViewModel: EmailInfoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileStatsOldViewModel::class)
    internal abstract fun bindUserProfileViewModel(profileStatsOldViewModel: ProfileStatsOldViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MagicViewModel::class)
    internal abstract fun bindMagicViewModel(magicViewModel: MagicViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserTagViewModel::class)
    internal abstract fun bindUserTagViewModel(userTagViewModel: UserTagViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BattleViewModel::class)
    internal abstract fun bindBattleViewModel(battleViewModel: BattleViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MapViewModel::class)
    internal abstract fun bindMapViewModel(mapViewModel: MapViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(StatsViewModel::class)
    internal abstract fun bindStatsViewModel(statsViewModel: StatsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserStatsViewModel::class)
    internal abstract fun bindUserStatsViewModel(userStatsViewModel: UserStatsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NotificationViewModel::class)
    internal abstract fun bindNotificationViewModel(notificationViewModel: NotificationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CommunityViewModel::class)
    internal abstract fun bindCommunityViewModel(communityViewModel: CommunityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FindBattleViewModel::class)
    internal abstract fun bindFindBattleViewModel(findBattleViewModel: FindBattleViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreateTeamViewModel::class)
    internal abstract fun bindCreateTeamViewModel(createTeamViewModel: CreateTeamViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SelectPlayersViewModel::class)
    internal abstract fun bindSelectPlayersViewModel(selectPlayersViewModel: SelectPlayersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TeamsCreatedViewModel::class)
    internal abstract fun bindTeamsCreatedViewModel(teamsCreatedViewModel: TeamsCreatedViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EditTeamViewModel::class)
    internal abstract fun bindEditTeamViewModel(editTeamViewModel: EditTeamViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(OrganiserBattleViewModel::class)
    internal abstract fun bindOrganiserBattleViewModel(organiserBattleViewModel: OrganiserBattleViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NonOrganiserBattleViewModel::class)
    internal abstract fun bindNonOrganiserBattleViewModel(nonOrganiserBattleViewModel: NonOrganiserBattleViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FindPlayersViewModel::class)
    internal abstract fun bindFindPlayersViewModel(findPlayersViewModel: FindPlayersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EditVenueNameViewModel::class)
    internal abstract fun bindVenueNameViewModel(venueNameViewModel: EditVenueNameViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignalRViewModel::class)
    internal abstract fun bindSignalRViewModel(signalRViewModel: SignalRViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RadarViewModel::class)
    internal abstract fun bindRadarViewModel(radarViewModel: RadarViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreateBattleViewModel::class)
    internal abstract fun bindCreateBattleViewModel(createBattleViewModel: CreateBattleViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileStatsViewModel::class)
    internal abstract fun bindProfileStatsViewModel(profileStatsViewModel: ProfileStatsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RecordingViewModel::class)
    internal abstract fun bindRecordingViewModel(recordingViewModel: RecordingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GameOverViewModel::class)
    internal abstract fun bindGameOverViewModel(gameOverViewModel: GameOverViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SendReloadViewModel::class)
    internal abstract fun bindSendReloadViewModel(sendReloadViewModel: SendReloadViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GiftReloadViewModel::class)
    internal abstract fun bindGiftReloadViewModel(giftReloadViewModel: GiftReloadViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BattleAlertViewModel::class)
    internal abstract fun bindBattleAlertViewModel(battleAlertViewModel: BattleAlertViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ChatViewModel::class)
    internal abstract fun bindChatViewModel(chatViewModel: ChatViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BattleOptionsViewModel::class)
    internal abstract fun bindBattleOptionsViewModel(battleOptionsViewModel: BattleOptionsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BattleRecordViewModel::class)
    internal abstract fun bindBattleRecordViewModel(battleRecordViewModel: BattleRecordViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FullscreenImageViewModel::class)
    internal abstract fun bindFullscreenImageViewModel(fullscreenImageViewModel: FullscreenImageViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EliminateViewModel::class)
    internal abstract fun bindEliminateViewModel(eliminateViewModel: EliminateViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MapSimpleViewModel::class)
    internal abstract fun bindMapSimpleViewModel(mapSimpleViewModel: MapSimpleViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GearPairingViewModel::class)
    internal abstract fun bindDevicesViewModel(devicesViewModel: GearPairingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SelectVenueViewModel::class)
    internal abstract fun bindSelectViewModel(selectVenueViewModel: SelectVenueViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MiniProfileStatsViewModel::class)
    internal abstract fun bindMiniProfileStatsViewModel(factory: MiniProfileStatsViewModel): ViewModel
}
