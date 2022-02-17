package com.gts.assignment.base

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * A Base ViewModel for all other viemmodels.
 * All ViewModels can extends this class
 */
@HiltViewModel
open class BaseViewModel @Inject constructor() : ViewModel() {

}