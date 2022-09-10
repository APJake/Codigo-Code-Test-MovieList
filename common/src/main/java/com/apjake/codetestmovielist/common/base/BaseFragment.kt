package com.apjake.codetestmovielist.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment() {

    private var _binding: VB? = null

    protected abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
    protected abstract val mainViewModel: VM
    protected abstract fun setUp()
    protected abstract fun observeState()
    protected abstract fun observeEvent()

    private var _toast: Toast? = null
    private var _snackBar: Snackbar? = null

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = bindingInflater.invoke(layoutInflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
        observeState()
        observeEvent()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun showToastMessage(message: String){
        _toast?.cancel()
        _toast = Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT)
        _toast?.show()
    }

    fun showErrorSnackBar(message: String, onRetry: ()-> Unit){
        _snackBar?.dismiss()
        _snackBar = Snackbar.make(binding.root, message, Snackbar.LENGTH_INDEFINITE)
            .setAction("Retry"){
                onRetry()
            }
        _snackBar?.show()
    }
}